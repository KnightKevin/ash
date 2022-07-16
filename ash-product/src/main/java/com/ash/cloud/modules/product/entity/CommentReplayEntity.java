package com.ash.cloud.modules.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ash.cloud.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 商品评价回复关系
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-12
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_comment_replay")
public class CommentReplayEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
	private Long commentId;
    /**
     * 回复id
     */
	private Long replyId;
}