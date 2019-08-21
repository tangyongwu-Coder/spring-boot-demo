package com.xinyan.boot.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ChannelBeanInfo实体类
 * 
 * @author 孟星魂
 * @version 5.0 createTime: 2019-01-04
  */
@Data
public class ChannelBeanInfo implements Serializable {

	private static final long serialVersionUID = 6781625621520745913L;
	/**
    * 编号
    */
	private Integer id;
   /**
    * BEAN名称
    */
	private String beanName;
   /**
    * BEAN描述
    */
	private String beanDesc;
   /**
    * BEAN内容
    */
	private byte[] beanContent;

   /**
    * 删除标识 0 正常 1 删除
    */
	private String deleteFlag;
   /**
    * 创建人
    */
	private String createdBy;
   /**
    * 创建时间
    */
	private Date createdAt;
   /**
    * 最后更新时间
    */
	private Date updatedAt;
   /**
    * 最后更新人
    */
	private String updatedBy;
}
