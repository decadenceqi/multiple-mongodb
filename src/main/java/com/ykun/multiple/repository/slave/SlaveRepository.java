package com.ykun.multiple.repository.slave;

import com.ykun.multiple.core.BaseMongoRepository;
import com.ykun.multiple.domain.HelloWorld;

/**
 * Created by yankun on 2017/6/16.
 */
public interface SlaveRepository extends BaseMongoRepository<HelloWorld, String> {
}
