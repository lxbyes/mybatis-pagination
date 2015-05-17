package me.leckie.pagination.mybatis;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.github.pagehelper.SqlUtil;

/**
 * use mybatis interceptor to pagination<br>
 * 
 * @author leckie
 * @date May 11, 2015
 */
// @Intercepts(@Signature(type = StatementHandler.class, method = "prepare",
// args = { Connection.class }))
@Intercepts(@Signature(type = Executor.class, method = "query", args = {
        MappedStatement.class, Object.class, RowBounds.class,
        ResultHandler.class }))
public class PaginationInterceptor implements Interceptor {

    private Properties properties;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        final Object[] args = invocation.getArgs();
        for (Object arg : args) {
            System.out.println(">>>" + arg);
            System.out.println("<<<" + arg.getClass());
        }

        // final Object[] args = invocation.getArgs();
        // RowBounds rowBounds = (RowBounds) args[2];
        // if (SqlUtil.getLocalPage() == null && rowBounds == RowBounds.DEFAULT)
        // {
        // return invocation.proceed();
        // } else {
        // //忽略RowBounds-否则会进行Mybatis自带的内存分页
        // args[2] = RowBounds.DEFAULT;
        // //分页信息
        // Page page = getPage(rowBounds);
        // //pageSizeZero的判断
        // if ((page.getPageSizeZero() != null && page.getPageSizeZero()) &&
        // page.getPageSize() == 0) {
        // //执行正常（不分页）查询
        // Object result = invocation.proceed();
        // //得到处理结果
        // page.addAll((List) result);
        // //相当于查询第一页
        // page.setPageNum(1);
        // //这种情况相当于pageSize=total
        // page.setPageSize(page.size());
        // //仍然要设置total
        // page.setTotal(page.size());
        // //返回结果仍然为Page类型 - 便于后面对接收类型的统一处理
        // return page;
        // }
        // //获取原始的ms
        // MappedStatement ms = (MappedStatement) args[0];
        // SqlSource sqlSource = ms.getSqlSource();
        // //简单的通过total的值来判断是否进行count查询
        // if (page.isCount()) {
        // //将参数中的MappedStatement替换为新的qs
        // msUtils.processCountMappedStatement(ms, sqlSource, args);
        // //查询总数
        // Object result = invocation.proceed();
        // //设置总数
        // page.setTotal((Integer) ((List) result).get(0));
        // if (page.getTotal() == 0) {
        // return page;
        // }
        // }
        // //pageSize>0的时候执行分页查询，pageSize<=0的时候不执行相当于可能只返回了一个count
        // if (page.getPageSize() > 0 &&
        // ((rowBounds == RowBounds.DEFAULT && page.getPageNum() > 0)
        // || rowBounds != RowBounds.DEFAULT)) {
        // //将参数中的MappedStatement替换为新的qs
        // msUtils.processPageMappedStatement(ms, sqlSource, page, args);
        // //执行分页查询
        // Object result = invocation.proceed();
        // //得到处理结果
        // page.addAll((List) result);
        // }
        // //返回结果
        // return page;

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return this.properties;
    }

}
