package com.ykun.multiple.repository.master;

import com.ykun.multiple.core.BaseMongoRepository;
import com.ykun.multiple.domain.HelloWorld;

/**
 * Created by yankun on 2017/6/16.
 */
public interface MasterRepository extends BaseMongoRepository<HelloWorld, String> {
}
