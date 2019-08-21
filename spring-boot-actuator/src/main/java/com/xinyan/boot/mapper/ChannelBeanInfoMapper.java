package com.xinyan.boot.mapper;


import com.xinyan.boot.model.ChannelBeanInfo;

import java.util.List;

/**
 * ChannelBeanInfo数据库操作
 * 
 * @author 孟星魂
 * @version 5.0 createTime: 2019-01-04
  */
public interface ChannelBeanInfoMapper {

 /**
     * 添加对象所有字段
     *
     * @param record 插入字段对象
     * @return 新增记录数
     */
    int insert(ChannelBeanInfo record);

    /**
     * 删除对象
     *
     * @param record 删除对象
     * @return
     */
    int delete(ChannelBeanInfo record);

    /**
     * 根据ID修改对应字段
     *
     * @param record 修改字段对象
     * @return 修改记录数
     */
    int updateByPrimaryKeySelective(ChannelBeanInfo record);

    /**
     * 批量新增规则
     * @param rules 需要新增的规则集合
     * @return 新增成功记录数
     */
    int insertBatch(List<ChannelBeanInfo> rules);

    /**
     * 根据条件查询
     *
     * @param query 查询条件
     * @return 查询结果
     */
    List<ChannelBeanInfo> selectBySelective(ChannelBeanInfo query);
    /**
     * 根据ID查询
     *
     * @param id 主键ID
     * @return 查询结果
     */
    ChannelBeanInfo selectByPrimaryKey(Integer id);
}
