package me.leckie.pagination.mybatis;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * use mybatis interceptor to pagination<br>
 * 
 * @author leckie
 * @date May 11, 2015
 */
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }))
public class PaginationInterceptor implements Interceptor {

    private Properties properties;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        for (Object o : properties.keySet()) {
            System.out.println(o);
        }
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
