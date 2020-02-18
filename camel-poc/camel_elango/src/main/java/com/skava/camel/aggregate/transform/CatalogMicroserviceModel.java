/*******************************************************************************
\ * Copyright Â©2002-2018 Skava - All rights reserved.
 * 
 * All information contained herein is, and remains the property of Skava.
 * Skava including, without limitation, all software and other elements thereof, 
 * are owned or controlled exclusively by Skava and protected by copyright, patent
 * and other laws. Use without permission is prohibited. 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 *    
 * For further information contact Skava at info@skava.com.
 ******************************************************************************/
package com.skava.camel.aggregate.transform;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class CatalogMicroserviceModel is used to define microservice model of model entity.
 * @since Feb 2020
 * @version 8.7
 * @author Gangasri P
 */

@Getter
@Setter

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogMicroserviceModel implements Serializable{

  /**
   * Serial version id
   */
  private static final long serialVersionUID = -8690752563173793876L;

  /* The boolean parameter specifies whether the model is active or inactive. */
  private String status;

  /** It refers to the identifier of the model. */  
  private String modelId;

  /* It refers to the createdTime of the model. */
  private String createdTime;

  /* It refers to the createdBy of the model. */
  private long createdBy;

  /* It refers to the updatedOn of the model. */
  private String updatedTime;

  /* It refers to the updatedBy of the model. */
  private long updatedBy;

  /* It refers to the type of the model. */
  private String type;

  /* It refers the description of the model. */
  private String description;
}
