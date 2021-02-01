package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.archivo.extraer_ventas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.RecepcionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro.RegistroVentaCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas.validadores.VentaValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaErrorLecturaExcel;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.adapters.primary.EnumFacVentasMensajesShared;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.archivo.extraer_ventas.IArchivoExtraerVentas;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.UuidGenerator;

@Service
public final class ArchivoExtraerVentasServiceImpl implements IArchivoExtraerVentas {
	private final UuidGenerator uuidGenerator;
	private final VentaValidador validador;

	public ArchivoExtraerVentasServiceImpl(UuidGenerator uuidGenerator, VentaValidador validador) {
		this.uuidGenerator = uuidGenerator;
		this.validador = validador;
	}

	@Override
	public List<RegistroVentaCommand> extraerVentas(byte[] pArchivo, RecepcionResponse pRecepcion) throws IOException {
		return leerArchivo(pArchivo, pRecepcion);
	}

	public byte[] unZipFile(byte[] fileInByte) throws IOException {

		ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(fileInByte));
		ZipEntry entry = null;
		ByteArrayOutputStream out = null;
		while (zipStream.getNextEntry() != null) {
			out = new ByteArrayOutputStream();
			byte[] byteBuff = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = zipStream.read(byteBuff)) != -1) {
				out.write(byteBuff, 0, bytesRead);
			}
			out.close();
			zipStream.closeEntry();
		}
		zipStream.close();
		return out.toByteArray();
	}

	private List<RegistroVentaCommand> leerArchivo(byte[] pArchivo, RecepcionResponse pRecepcion) throws IOException {
		List<RegistroVentaCommand> commands = new ArrayList<>();
		InputStream file = // leer archivo excel
				new ByteArrayInputStream(unZipFile(pArchivo));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		// obtener la hoja que se va leer
		XSSFSheet sheet = workbook.getSheetAt(0);
		this.removeEmptyRows(sheet);
		// obtener todas las filas de la hoja excel
		Iterator<Row> rowIterator = sheet.iterator();

		rowIterator.next();

		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		DateTimeFormatter vFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		HashMap<String, ValidationResponse> vResutaldosValidacion = new HashMap<>();
		try {
			rowIterator.forEachRemaining(x -> commands.add(RegistroVentaCommand.newRegistroVentaCommand()
					.fila((long) x.getRowNum()).id(uuidGenerator.generate())
					.fechaFactura(LocalDate.parse(x.getCell(0).toString(), vFormatter))
					// .fechaFactura(
					// x.getCell(0).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
					.numeroFactura(Long.valueOf((long) x.getCell(1).getNumericCellValue()))
					.codigoAutorizacion(x.getCell(2).toString())
					.numeroDocumentoCliente(
							String.valueOf(new BigDecimal(x.getCell(4).getNumericCellValue()).toPlainString()))
					.nombreCliente(x.getCell(5).toString()).importeTotalVenta(new BigDecimal(x.getCell(6).toString()))
					.importeIceIehdTasas(new BigDecimal(x.getCell(7).toString()))
					.importeExento(new BigDecimal(x.getCell(8).toString()))
					.importeTasaCero(new BigDecimal(x.getCell(9).toString()))
					.subTotal(new BigDecimal(x.getCell(10).getNumericCellValue()))
					.descuento(new BigDecimal(x.getCell(11).getNumericCellValue()))
					.importeBase(new BigDecimal(x.getCell(12).getNumericCellValue()))
					// .debitoFiscal(new BigDecimal(x.getCell(13).toString()))
					.codigoControl(x.getCell(14).toString()).recepcionId(pRecepcion.id())
					.usuarioRegistro(pRecepcion.usuarioRegistro()).ifcProveedor(pRecepcion.ifc())
					.nitProveedor(pRecepcion.nit()).origenId("SER").build()));

		} catch (Exception e) {
			vResutaldosValidacion.put(pRecepcion.id(), crearValidacionLecturaArchivoExcel(pRecepcion.id()));
			this.guardarErrores(vResutaldosValidacion);
		}

		return commands;
	}

	private ValidationResponse crearValidacionLecturaArchivoExcel(String pRecepcionId) {
		// Asignar codigo mensaje lectura excel
		return new ValidationResponse(new HashMap<>() {
			{
				put(pRecepcionId, Arrays.asList(EnumFacVentasMensajesShared.EXCEL_INVALIDO.getId()));
			}
		});
	}

	private void guardarErrores(HashMap<String, ValidationResponse> vResutaldosValidacion) {
		throw new VentaErrorLecturaExcel(vResutaldosValidacion);
	}

	private void removeEmptyRows(XSSFSheet sheet) {
		Boolean isRowEmpty = Boolean.FALSE;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			if (sheet.getRow(i) == null) {
				isRowEmpty = true;
				sheet.shiftRows(i + 1, sheet.getLastRowNum() + 1, -1);
				i--;
				continue;
			}
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				if (sheet.getRow(i).getCell(j) == null || sheet.getRow(i).getCell(j).toString().trim().equals("")) {
					isRowEmpty = true;
				} else {
					isRowEmpty = false;
					break;
				}
			}
			if (isRowEmpty == true) {
				sheet.shiftRows(i + 1, sheet.getLastRowNum() + 1, -1);
				i--;
			}
		}
	}
}
