package Models;

import Models.DataBase;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartApp implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
       // start servlet ..
        DataBase.getInstance();
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
