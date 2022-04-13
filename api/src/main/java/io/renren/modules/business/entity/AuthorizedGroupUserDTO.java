package io.renren.modules.business.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分组管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizedGroupUserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Long> groupIds;
	private Long UserId;

}
