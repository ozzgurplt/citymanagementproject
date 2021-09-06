package com.cmproject.citymanagementproject.Service;

import com.cmproject.citymanagementproject.Model.Region;
import com.cmproject.citymanagementproject.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServicelmpl implements RegionService{
    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> getAllRegion() {
      return regionRepository.findAll();
    }

    @Override
    public void saveRegion(Region region) {
        this.regionRepository.save(region);
    }

    @Override
    public Region getRegionById(long id) {
        Optional<Region> optional = regionRepository.findById(id);
        Region region = null;
        if(optional.isPresent()){
            region= optional.get();
        }else{
            throw new RuntimeException("Region not found"+id);
        }
        return region;
    }

    @Override
    public void deleteRegionById(long id) {
        this.regionRepository.deleteById(id);
    }
}
