package br.com.alvaro.contrato.i.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import br.com.alvaro.contrato.i.entity.IEntity;

/**
 * Define o contrato de acesso ao <b>DB</b>,
 * Todas a classes que o implementarem deveram sobreescrever seus metodos
 * e ter uma tipagem que herde de <code>IEntity</code>, seguindo assim
 * nossa convencao para o Generics.
 * 
 * @author guilherme.magalhaes
 * @since 09/2014
 * @version 1.0
 * @see IEntity
 */
public interface IGenericDAO<T extends IEntity<?>> {

	/**
	 * Metodo pra salvar as entidades no <b>DB</b>.
	 * 
	 * @param entity
	 */
	void save (T entity);
	
	/**
	 * Metodo pra deletar as entidades no <b>DB</b>.
	 * 
	 * @param id
	 * @throws EntityNotFoundException
	 */
	void delete (Object id) throws EntityNotFoundException;
	
	/**
	 * Metodo pra recuperar a entidade no <b>DB</b> pelo seu <b>ID</b>.
	 * 
	 * @param id
	 * @return
	 * @throws EntityNotFoundException
	 */
	T getById(Object id) throws EntityNotFoundException;
	
	/**
	 * Metodo pra recuperar tudo nas entidades no <b>DB</b>.
	 * 
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * Metodo pra recuperar valores no <b>DB</b> pelos parametros usados,
	 * Recebemos os fields que queremos recuperar, o exclusive pra verificar
	 * AND or NOT, o maximo de resultados que queremos retornar e o ORDERBY.
	 * 
	 * @param fields
	 * @param exclusive
	 * @param maxResults
	 * @param orderBy
	 * @return
	 */
	List<T> findByFields(Map<String, Object> fields, Boolean exclusive, int maxResults, String orderBy);
}