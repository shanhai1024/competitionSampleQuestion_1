package com.zhonghui.quartz.util;

import org.quartz.JobExecutionContext;
import com.zhonghui.quartz.domain.SysJob;

/**
 * 定时任务处理（允许并发执行）
 * 
 * @author zhonghui
 *
 */
public class QuartzJobExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
