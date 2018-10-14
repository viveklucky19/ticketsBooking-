/**
 * 
 */
package com.example.udaan.Test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.udaan.Test.Entity.ScreenInfoEntity;

/**
 * @author Vivek Sanodiya
 */

@Repository
public interface ScreenInfoRepository extends JpaRepository<ScreenInfoEntity, Long> {

}
