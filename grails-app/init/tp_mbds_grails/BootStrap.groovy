package tp_mbds_grails


class BootStrap {

    def init = { servletContext ->
        SecUser adminUser = new SecUser(username: "user123", password: "azertyuiop1", enabled: true).save(flush:true)
        SecRole roleAdmin = new SecRole(authority: 'ROLE_ADMIN').save(flush:true)
        SecUserSecRole.create(adminUser,roleAdmin,true)

        println(SecUser.count())
        println(SecRole.count())
        println(SecUserSecRole.count())

    }
    def destroy = {
    }
}
