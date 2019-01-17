package com.rongyi.easy.rmmm.vo;

import java.io.Serializable;
import java.util.List;
/**
 * 摩店商品规格返回
 * @author user
 *
 */
public class RmmCommoditySpecVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String columnId;//规格名称对应的id
	private String columnName;//规格名称
	private List<String> columnValue;//规格名称对应的值集合
	public String getColumnId() {
		return columnId;
	}
	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public List<String> getColumnValue() {
		return columnValue;
	}
	public void setColumnValue(List<String> columnValue) {
		this.columnValue = columnValue;
	}
	@Override
	public String toString() {
		return "CommoditySpecVO [columnId=" + columnId + ", columnName="
				+ columnName + ", columnValue=" + columnValue + "]";
	}
	
}