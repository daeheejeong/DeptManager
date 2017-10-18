package com.capstone.deptmanager.schedule.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.deptmanager.common.Constants;
import com.capstone.deptmanager.schedule.bean.ScheduleBean;
import com.capstone.deptmanager.schedule.service.ScheduleService;

@Controller
public class ScheduleController {

	// 파일 업로드 저장경로
	@Value("#{config['file.upload.path']}")
	private String FILE_UPLOAD_PATH;

	// 서비스 선언
	@Autowired
	private ScheduleService scheduleService;
	
	// 일정 화면
	@RequestMapping("/schedule/scheduleForm")
	public String scheduleForm() {
		return "/schedule/scheduleForm";
	} 
	
	@RequestMapping("/schedule/selectScheduleProc")
	public Map<String, Object> selectScheduleProc() {
	
		
		return null;
	} 
	
	
	@RequestMapping("/schedule/insertScheduleProc")
	@ResponseBody
	public Map<String, Object> insertScheduleProc(ScheduleBean bean) {
		
		bean.setScheduleDesc("test");
		bean.setScheduleAllday(1);
		
		Map<String, Object> resMap = new HashMap<String, Object>();

		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "일정 등록에 실패했습니다.");
		
		Logger logger = Logger.getLogger(this.getClass());
		
		logger.info(bean.toString());
		
		try {
			int res = scheduleService.insertScheduleProc(bean);
			logger.debug("res : " + res);

			if(res > 0){
				resMap.put(Constants.RESULT, Constants.RESULT_SUCCESS);
				resMap.put(Constants.RESULT_MSG, "일정 등록에 성공했습니다.");
			}
		} catch(Exception e) {
			
		}
	
		return resMap;
	} 
	
	@RequestMapping("/schedule/selectScheduleListProc")
	@ResponseBody
	public Map<String, Object> selectScheduleListProc() {
		Map<String, Object> resMap = new HashMap<String, Object>();

		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "일정 조회에 실패했습니다.");
		
		Logger logger = Logger.getLogger(this.getClass());
		try {
			List<ScheduleBean> schedules = scheduleService.selectScheduleListProc();
			
			if(schedules != null || schedules.size() > 1){
				resMap.put(Constants.RESULT, Constants.RESULT_SUCCESS);
				resMap.put(Constants.RESULT_MSG, "일정조회에 성공했습니다.");
				resMap.put("schedules", schedules);
			}
		} catch(Exception e) {
			
		}
	
		return resMap;
	} 
	
	
	
}