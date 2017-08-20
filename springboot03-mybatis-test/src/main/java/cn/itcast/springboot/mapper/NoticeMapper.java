package cn.itcast.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.itcast.springboot.domain.Notice;

/**
 * NoticeMapper
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年8月18日 上午11:29:05
 * @version 1.0
 */
@Mapper // 加@Mapper注解，就会创建它的代理对象
public interface NoticeMapper {
	@Select("select * from notice")
	List<Notice> findAll();
	
	/** 查询总记录数 */
	Long count();
	
	/** 分页查询 */
	List<Notice> findByPage(@Param("page")int page,@Param("rows")Integer rows);
	
}
