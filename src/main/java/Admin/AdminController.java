package Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {
    private  AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping
    public List<Admin> getAdmin(){
        return AdminService.getAdmin();
    }
    @PostMapping
    public void registerNewAdmin(@RequestBody Admin admin) throws IllegalAccessException {
        adminService.addNewAdmin(admin);
    }

    private <Admin> void addNewAdmin(Admin admin) {
    }

    @DeleteMapping(path="{adminId}")
    public void deleteadmin(
            @PathVariable("AdminId") Long AdminId) throws IllegalAccessException {
        adminService.deleteAdmin(AdminId);
    }
    @PutMapping (path="{adminId}")
    public void updateadmin(
            @PathVariable("adminId")Long adminId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        adminService.updateStudent(adminId,name,email);

    }
}

