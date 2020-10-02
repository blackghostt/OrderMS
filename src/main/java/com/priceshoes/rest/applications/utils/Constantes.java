package com.priceshoes.rest.applications.utils;

public class Constantes 
{
	public static int COD_ERROR_EXCEPCION = 99;
	public static String COD_ERROR_EXCEPCION_MSJ = "ERROR DESCONOCIDO";
	public static int COD_ERROR_ENTRADA_INSUFICIENTE = 1;
	public static String COD_ERROR_ENTRADA_INSUFICIENTE_MSJ = "Los parámetros de entrada son insuficientes para procesar la solicitud.";
	public static int COD_ERROR_OBJETO_NO_ENCONTRADO = 2;
	public static String COD_ERROR_OBJETO_NO_ENCONTRADO_MSJ = "Objeto no encontrado";
	public static int COD_ERROR_VALIDACION_SEGURIDAD = 3;
	public static String COD_ERROR_VALIDACION_SEGURIDAD_MSJ = "Código(s) de seguridad no válido(s).";
	public static int COD_ERROR_OBJETO_YA_EXISTE = 4;
	public static String COD_ERROR_OBJETO_YA_EXISTE_MSJ = "Registro ya existente en la BD.";
	public static int COD_ERROR_FORMATO_NO_VALIDO = 5;
	public static String COD_ERROR_FORMATO_NO_VALIDO_MSJ = "Formato no válido";
	public static int COD_ERROR_SQL = 6;
	public static String COD_ERROR_SQL_MSJ = "ERROR DE BASE DE DATOS";
	public static int COD_ERROR_FORMATO_DIRECCION = 7;
	public static String COD_ERROR_FORMATO_DIRECCION_MSJ = "ERROR EN FORMATO DE DIRECCION";
	public static int COD_ERROR_FORMATO_ARTICULO = 8;
	public static String COD_ERROR_FORMATO_ARTICULO_MSJ = "ERROR EN FORMATO DE ARTICULO";
	public static final int TIPO_VALIDACION_DOB = 1;
	public static final int TIPO_VALIDACION_AFILIACION = 2;
	public static final int POR_EMAIL = 1;
	public static final int POR_ID = 2;

	//-Formas de pago
	public static final String SALDO			=	"S";
	public static final String CREDIPRICE		=	"C";
	public static final String CUPON_AFILIACION	=	"V";
	public static final String PAYPAL			=	"Y";
	public static final String TARJETA_CREDITO	=	"W";
	
	//Tipo de saldo
	public static final String NOTA				=	"N";
	public static final String VALE				=	"V";
	public static final String SALDO_SOCIO		=	"S";
	
}