package py.com.solumed.common.constants;

import static py.com.solumed.common.constants.ProtectedResource.API_ROOT;

import py.com.solumed.seguridad.constantes.Role;



/**
 * Created by mcespedes
 */
public enum ProtectedModule implements ProtectableModule {

    ORGANIZATIONS {
        private String[] urls = { API_ROOT + "/activities", API_ROOT + "/activities/**", API_ROOT + "/applications",
                API_ROOT + "/applications/**", API_ROOT + "/organizations", API_ROOT + "/organizations/**",
                API_ROOT + "/user-applications", API_ROOT + "/users-applications/**", API_ROOT + "/users",
                API_ROOT + "/usuarios/**", API_ROOT + "/user-roles", API_ROOT + "/user-roles/**", API_ROOT + "/families",
                API_ROOT + "/families/**", API_ROOT + "/cities", API_ROOT + "/cities/**", API_ROOT + "/countries",
                API_ROOT + "/countries/**", API_ROOT + "/parameters", API_ROOT + "/parameters/**", API_ROOT + "/people",
                API_ROOT + "/people/**", };

        private String[] readRoles = { Role.ADMIN.getSecurityName(), Role.USER.getSecurityName() };

        private String[] writeRoles = { 
                Role.ADMIN.getSecurityName()};

        @Override
        public String[] getUrls() {
            return urls;
        }

        @Override
        public String[] getReadRoles() {
            return readRoles;
        }

        @Override
        public String[] getWriteRoles() {
            return writeRoles;
        }

    },
    SURVEYS {
        private String[] urls = { API_ROOT + "/surveys", API_ROOT + "/surveys/**", API_ROOT + "/snapshots",
                API_ROOT + "/snapshots/**" };

        private String[] readRoles = { Role.ADMIN.getSecurityName(), Role.USER.getSecurityName() };

        private String[] writeRoles = { Role.ADMIN.getSecurityName() };

        @Override
        public String[] getUrls() {
            return urls;
        }

        @Override
        public String[] getReadRoles() {
            return readRoles;
        }

        @Override
        public String[] getWriteRoles() {
            return writeRoles;
        }
    }

}
