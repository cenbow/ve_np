package com.ve.marketingcenter.core.dao.coupon;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ve.marketingcenter.core.domain.coupon.BaseDo;

public class BaseDao extends SqlMapClientDaoSupport {

	public int delete(BaseDo bo) {
		return delete(getStatementName(bo.getClass(), "delete"), bo);
	}

	public int delete(String statementName, BaseDo bo) {
		return getSqlMapClientTemplate().delete(statementName, bo);
	}

	public BaseDo insert(BaseDo bo) {
		return insert(getStatementName(bo.getClass(), "add"), bo);
	}

	public BaseDo insert(String statementName, BaseDo bo) {
		Object result = getSqlMapClientTemplate().insert(statementName, bo);
		if (result == null) {
			return bo;
		} else {
			return get(bo);
		}
	}

	public void batchInsert(String statementName, List list) {
		getSqlMapClientTemplate().insert(statementName, list);
	}

	public int update(BaseDo bo) {
		return update(getStatementName(bo.getClass(), "update"), bo);
	}

	public int update(String statementName, BaseDo bo) {
		return getSqlMapClientTemplate().update(statementName, bo);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int batchUpdate(final String statementName, final List list) {
		// return getSqlMapClientTemplate().update(statementName, list);
		return (Integer) getSqlMapClientTemplate().execute(
				new SqlMapClientCallback() {
					@Override
					public Object doInSqlMapClient(SqlMapExecutor executor)
							throws SQLException {
						executor.startBatch();
						for (Object obj : list) {
							executor.update(statementName, obj);
						}
						return executor.executeBatch();
					}
				});
	}

	public BaseDo get(BaseDo bo) {
		return (BaseDo) getSqlMapClientTemplate().queryForObject(
				getStatementName(bo.getClass(), "get"), bo);
	}

	private String getStatementName(Class classT, String crudName) {
		String className = classT.getName().substring(
				classT.getName().lastIndexOf(".") + 1);
		return className.toUpperCase() + "." + crudName + className;
	}

	public Object queryForObject(String statementName, Object obj) {
		return getSqlMapClientTemplate().queryForObject(statementName, obj);
	}

	public List queryForList(String statementName, Object obj) {
		return getSqlMapClientTemplate().queryForList(statementName, obj);
	}

}
