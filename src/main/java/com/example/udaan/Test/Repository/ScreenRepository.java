/**
 * 
 */
package com.example.udaan.Test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.udaan.Test.Entity.ScreenEntity;

/**
 * @author Vivek Sanodiya
 */
@Repository
public interface ScreenRepository extends JpaRepository<ScreenEntity, Long> {

	public ScreenEntity findByScreenName(String screenName);

}
