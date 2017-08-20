package cn.itcast.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.service.NoticeService;

/**
 * NoticeController
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年8月18日 上午11:31:55
 * @version 1.0
 */
@RestController
public class NoticeController {
	
	/** 注入业务层 */
	@Autowired
	private NoticeService noticeService;
	
	/** 查询所有的公告 */
	@GetMapping("/findAll")
	public List<Notice> findAll(){
		return noticeService.findAll();
	}
	
	/** 分页查询公告 */
	@PostMapping("/findByPage") 
	public Map<String, Object> findByPage(@RequestParam(value="page", defaultValue="1") Integer page, 
			@RequestParam(value="rows", defaultValue="15") Integer rows){
		// {"total": 30, "rows" : [{},{}]}
		return noticeService.findByPage(page, rows);
	}
	
}
