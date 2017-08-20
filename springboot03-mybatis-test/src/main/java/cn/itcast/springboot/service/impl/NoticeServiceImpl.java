package cn.itcast.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.mapper.NoticeMapper;
import cn.itcast.springboot.service.NoticeService;

/**
 * NoticeServiceImpl
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年8月18日 上午11:30:53
 * @version 1.0
 */
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

	/** 注入数据访问接口 */
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<Notice> findAll() {
		return noticeMapper.findAll();
	}
	
	/** 分页查询公告 */
	public Map<String, Object> findByPage(Integer page, Integer rows){
		// {"total": 30, "rows" : [{},{}]}
		/** 查询总记录数 */
		Long total = noticeMapper.count();
		/** 分页查询 */
		List<Notice> notices = noticeMapper.findByPage((page - 1) * rows, rows);
		
		Map<String, Object> data = new HashMap<>();
		data.put("total", total);
		data.put("rows", notices);
		return data;
		
	}

}
