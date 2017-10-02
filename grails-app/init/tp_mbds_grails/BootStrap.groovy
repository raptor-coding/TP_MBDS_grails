package tp_mbds_grails
//Debug apache tomcat : netstat -aon | find ":80" | find "LISTENING"

class BootStrap {

    def init = { servletContext ->


        SecUser adminUser = new SecUser(username: "IamRoot", password: "root", enabled: true).save(flush:true)
        SecUser moderatorUser = new SecUser(username: "IamModerator", password: "moderator", enabled: true).save(flush:true)
        SecUser utilUser = new SecUser(username: "IamUser", password: "user", enabled: true).save(flush:true)
        SecRole roleAdmin = new SecRole(authority: 'ROLE_ADMIN').save(flush:true)
        SecRole roleModer = new SecRole(authority: 'ROLE_MODER').save(flush:true)
        SecRole roleUser = new SecRole(authority: 'ROLE_USER').save(flush:true)
        SecUserSecRole.create(adminUser,roleAdmin,true)
        SecUserSecRole.create(moderatorUser,roleModer,true)
        SecUserSecRole.create(utilUser,roleUser,true)

        println(SecUser.count())
        println(SecRole.count())
        println(SecUserSecRole.count())

        POI myfirstpoi
        POIImage myfirstimage
        POIsGroup group
        GroupImage mysecondimage

        for (def i = 0; i <10; i++) {

            myfirstimage = new POIImage(path:'apple-touch-icon-retina.png')
            mysecondimage = new GroupImage(path:'apple-touch-icon-retina.png')
            myfirstpoi = new POI(name:'my poi'+i, latitude:0, longitude:0, description: 'my poi description'+i)
            myfirstpoi.addToImages(myfirstimage)
            group = new POIsGroup(name :'my group'+i).addToPois(myfirstpoi).save()
            group.addToImages(mysecondimage).save()

            myfirstimage = null
            myfirstpoi = null
            group = null

        }




        
    }
    def destroy = {
    }
}
