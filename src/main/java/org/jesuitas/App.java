package org.jesuitas;

import org.jesuitas.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HibernateUtils.initSession();
        HibernateUtils.closeSession();
    }
}
