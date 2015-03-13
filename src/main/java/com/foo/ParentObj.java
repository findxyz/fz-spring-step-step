package com.foo;

import java.util.Properties;

/**
 * Created by Administrator on 2015-3-9.
 */
public abstract class ParentObj {
    private Properties adminEmails;

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    public Properties getAdminEmails() {
        return adminEmails;
    }
}
