package Admin;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminService {
    private static AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public static List<Admin> getAdmin() {
        return adminRepository.findAll();
    }

    public void addNewAdmin(Admin admin) throws IllegalAccessException {
        Optional<Admin> adminOptional = adminRepository
                .findAdminByEmail(admin.getEmail());
        if(adminOptional.isPresent()){
            throw new IllegalAccessException("email taken ");
        }

       adminRepository.save(admin);
    }


    public void deleteAdmin(Long adminId) throws IllegalAccessException {
        boolean exists=adminRepository.existsById(adminId);
        if(exists){
            throw  new IllegalAccessException("Admin with id"+adminId+"does not exists");
        }
        adminRepository.deleteById(adminId);
}
@Transactional
    public void updateStudent(Long adminId,
                              String name,
                              String email) {
        Admin admin=adminRepository.findById(adminId)
                .orElseThrow(()->new IllegalStateException(
                        "admin with id"+adminId+"dose not exist"
                ));
        if(name!=null && name.length()>0 && !Objects.equals(admin.getName(),name)){
            admin.setName(name);
        }
        if(email!=null &&
                email.length()>0 &&
                !Objects.equals(admin.getEmail(),email)){
            Optional<Admin> studentOptional=adminRepository
                    .findAdminByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email Taken");
            }
            admin.setEmail(email);
        }
    }
    }
