package cn.com.hosp.www.sys.schedule;


import cn.com.hosp.www.sys.service.WorkerTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledTask {

    @Autowired
    private WorkerTaskService workerTaskService;

    @Scheduled(cron = "0 0 0 * * ? ")
    public void workerTaskCountScheduled(){
        log.info("开始重置当天数量");
        workerTaskService.resetTodayCount();

    }

}
