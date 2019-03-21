package com.kocfinans.kocfinans.converter;

import com.kocfinans.kocfinans.command.RoleCommand;
import com.kocfinans.kocfinans.domain.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToRoleCommandConverter implements Converter<Role, RoleCommand> {


    @Override
    public RoleCommand convert(Role role) {
        if(role == null)
            return null;

        RoleCommand roleCommand = new RoleCommand();
        roleCommand.setId(role.getId());
        roleCommand.setRole(role.getRole());

        return roleCommand;
    }
}
