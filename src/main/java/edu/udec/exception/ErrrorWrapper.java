package edu.udec.exception;

import java.time.LocalTime;

public class ErrrorWrapper {
	
	private LocalTime fecha;
	
	private String mensaje;
	
	private String descripcion;
	
	

	public ErrrorWrapper(String mensaje, String descripcion) {
		super();
		this.fecha = LocalTime.now();
		this.mensaje = mensaje;
		this.descripcion = descripcion;
	}

	public LocalTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalTime fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
