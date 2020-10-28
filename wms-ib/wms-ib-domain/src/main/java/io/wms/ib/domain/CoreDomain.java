package io.wms.ib.domain;

import io.github.dddplus.annotation.Domain;

/**
 * 复杂的业务上下文BC(bounded context)，可以被分割成：(1个核心域 + N个支撑域).
 *
 * <p>每个支持域可以是单独module，也可以是单独的source code repo，通过domain service进行交互.</p>
 * <p>每个支持域是自治的，业务完备的.</p>
 */
@Domain(code = CoreDomain.CODE, name = "核心域")
public class CoreDomain {
    public static final String CODE = "core";

}
