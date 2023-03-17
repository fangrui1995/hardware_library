package com.hl.hardwareLibrary.sys;//package com.wtkj.task.service.com.ahsh.home.sys;
//
//import com.sgcc.isc.core.orm.identity.Department;
//import com.wtkj.internalsimulation.dao.domain.SysSsoOrganization;
//import com.wtkj.internalsimulation.dao.mapper.SysSsoOrganizationMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import javax.com.ahsh.home.annotation.Resource;
//import java.util.List;
//
//@Slf4j
//@Service
//public class SysSsoOrganizationService {
//
//    @Resource
//    private SysSsoOrganizationMapper ssoOrganizationMapper;
//
//    public void addBaseOrg(List<Department> departments){
//        departments.forEach(dept->{
//            SysSsoOrganization org = this.getOrgById(dept.getId());
//            if(null == org){
//                org = new SysSsoOrganization();
//                org.setName(dept.getName());
//                org.setId(dept.getId());
//                org.setParentId(dept.getParentId());
//                org.setAttr(dept.getNatureCode());
//                org.setShortName(dept.getOrgShortName());
//                org.setCode(dept.getCode());
//                org.setPathNames("基准组织");
//                ssoOrganizationMapper.insert(org);
//            }
//        });
//    }
//
//    public SysSsoOrganization getOrgById(String id){
//        return  ssoOrganizationMapper.selectOne(new SysSsoOrganization().setId(id));
//    }
//}
