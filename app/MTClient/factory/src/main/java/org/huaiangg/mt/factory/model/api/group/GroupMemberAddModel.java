package org.huaiangg.mt.factory.model.api.group;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-04-09 16:00
 */
public class GroupMemberAddModel {
    private Set<String> users = new HashSet<>();

    public GroupMemberAddModel(Set<String> users) {
        this.users = users;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }
}
