package com.cmproject.citymanagementproject.Service;

import com.cmproject.citymanagementproject.Model.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegionService {
    List<Region> getAllRegion();
    void saveRegion(Region region);
    Region getRegionById(long id);
    void deleteRegionById(long id);
}
