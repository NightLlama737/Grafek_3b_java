package org.example.accounts;

import com.google.inject.Singleton;

@Singleton
public class ShareFactory {
    public Share createNewShare(String name,double part,double balance,double divident )
    {
        return new Share(name,part,balance,divident);
    }
}
