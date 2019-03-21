package com.kocfinans.kocfinans.converter;


import com.kocfinans.kocfinans.command.RoleCommand;
import com.kocfinans.kocfinans.domain.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleCommandToRoleConverter implements Converter<RoleCommand, Role> {
    @Override
    public Role convert(RoleCommand roleCommand) {
        if (roleCommand == null)
            return null;

        Role role = new Role();

        role.setId(roleCommand.getId());
        role.setRole(roleCommand.getRole());

        return role;
    }
}