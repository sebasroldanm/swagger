package edu.udec.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de la persona")
public class Persona {

	@ApiModelProperty(notes = "Edad debe ser entre 18 y 60")
	@Min(value = 18, message = "Debe ser mayor de eddad")
	@Max(value = 60, message = "Debe ser menor que 60")
	private int edad;
	
	@ApiModelProperty(notes = "Nombre del paciente")
	@Size(min = 3, message = "Nombre debe tener al menos 3 caracteres")
	private String nombre;
	
	public Persona() {
		
	}
	
	public Persona(int edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
