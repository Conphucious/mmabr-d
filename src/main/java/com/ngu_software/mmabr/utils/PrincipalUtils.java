package com.ngu_software.mmabr.utils;

import com.ngu_software.mmabr.model.UserPrincipal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrincipalUtils {

    /*
    Name: [xxxxxxxxxxx],
    Granted Authorities: [ROLE_USER],
    User Attributes: [id=xxxxxxxxxxx, username=xxxxxxxxxxx, avatar=xxxxxxxxxxx, discriminator=xxxxxxxxxxx, public_flags=0, flags=0, email=xxxxxxxxxxx@gmail.com, verified=true, locale=en-US, mfa_enabled=false]
     */

    public static UserPrincipal getPrincipalObject(String principal) {
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(principal);

        List<String> propertyList = new ArrayList<>();

        while (matcher.find()) {
            String[] properties = matcher.group().replaceAll("\\[|\\]", "").split(", ");
            for (String property : properties) {
                // gets param of attributes
                if (property.contains("=")) {
                    property = property.split("=")[1];
                }
                propertyList.add(property);
            }
        }

        return new UserPrincipal(propertyList.get(1), propertyList.get(2), propertyList.get(3), propertyList.get(4), propertyList.get(5), propertyList.get(8), Boolean.parseBoolean(propertyList.get(9)));
    }

}
