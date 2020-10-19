package co.com.app.palindroma.app.proceso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcesoPalindromo {
	
	private String texto; //Cadena de caracteres
	
	private String palindromo=""; //Cadena del Palindromo
	
	private int formaPalindromo=0; // '1': acca '2': aca 
	private int contador=0; // Contador de palindromos
	private int validarLongitudMaximaPalindromo;
	private int longitudMaximaParaValidar;
	
	private int guardarPosicion=0;
	private int guardarContador=0;
	private int guardarformaPalindromo=0;
	
	public void Buscar (String texto) {
		palindromo="";
		contador = 0;
		formaPalindromo=0;
		
		for(int i=0; i < texto.length()-1; i++) { // Recorrer la cadena de caracteres
				
			validarLongitudMaximaPalindromo = texto.length() - i;
			if (i > validarLongitudMaximaPalindromo) { //Validar la Longitud maxima que se debe recorrer
				longitudMaximaParaValidar = validarLongitudMaximaPalindromo-1;
			} else {
				longitudMaximaParaValidar = i;
			}
			
			for (int j=0; j < longitudMaximaParaValidar; j++) { //Encontrar Longitud del Palindromo
				
				if(texto.charAt(i) == texto.charAt(i+1) && formaPalindromo == 0 && j==0) {
					formaPalindromo = 1;
				}
				if (i>0 && j>0 && (i-j>0) && (i+j+formaPalindromo<texto.length())) {
					if(texto.charAt(i-j) == texto.charAt(i+j) && formaPalindromo == 1) {
						formaPalindromo=0;
						contador=contador+1;
					} else if (texto.charAt(i-j) == texto.charAt(i+j+formaPalindromo)) {
						contador = contador + 1;
					}
					else {
					
						if((contador > guardarContador) || (contador == guardarContador && formaPalindromo == 1) ) { //el palidromo con forma 1 siempre es mas largo
							guardarPosicion = i;
							guardarContador = contador;
							guardarformaPalindromo = formaPalindromo;
						}
						formaPalindromo = 0;
						contador = 0;
						break;
					}
					}
			}
			
		}
		for(int k = guardarPosicion-guardarContador; k <= guardarPosicion+guardarContador+guardarformaPalindromo; k++ ) {
			palindromo=palindromo+texto.charAt(k);
		//	
		}
		//palindromo=Integer.toString(guardarformaPalindromo);
		setPalindromo(palindromo);
	}

	public String getPalindromo() {
		return palindromo;
	}

	public void setPalindromo(String palindromo) {
		this.palindromo = palindromo;
	}
	
	
	
}
