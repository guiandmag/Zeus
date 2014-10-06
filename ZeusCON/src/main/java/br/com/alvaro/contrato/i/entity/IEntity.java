package br.com.alvaro.contrato.i.entity;

import java.io.Serializable;

/**
 * Interface que define um contrato global pra todas as classes qua a implementarem,
 * Definindo que todos que o implementarem deveram ter um <b>ID</b> com a tipagem
 * necessaria pra seguir a regra de negocio.
 * 
 * @author guilherme.magalhaes
 * @since 09/2014
 * @version 1.0
 */
public interface IEntity<T> extends Serializable {

	/**
	 * Retorna o metodo get do <b>ID</b> com a tipagem utilizada.
	 * 
	 * @return
	 */
	T getId();
	
}