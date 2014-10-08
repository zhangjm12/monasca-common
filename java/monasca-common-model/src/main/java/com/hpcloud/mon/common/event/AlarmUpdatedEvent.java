/*
 * Copyright (c) 2014 Hewlett-Packard Development Company, L.P.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.hpcloud.mon.common.event;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonRootName;

import com.hpcloud.mon.common.model.alarm.AlarmState;
import com.hpcloud.mon.common.model.alarm.AlarmSubExpression;
import com.hpcloud.mon.common.model.metric.MetricDefinition;

/**
 * Represents an alarm having been updated.
 */
@JsonRootName(value = "alarm-updated")
public class AlarmUpdatedEvent implements Serializable {
  private static final long serialVersionUID = -890221414491823712L;

  public String alarmId;
  public String tenantId;
  public String alarmDefinitionId;
  public List<MetricDefinition> alarmMetrics;
  public Map<String, AlarmSubExpression> subAlarms;
  public AlarmState alarmState;
  public AlarmState oldAlarmState;

  public AlarmUpdatedEvent() {}

  public AlarmUpdatedEvent(String alarmId, String alarmDefinitionId, String tenantId,
      List<MetricDefinition> alarmMetrics, Map<String, AlarmSubExpression> subAlarmMetricDefinitions,
      AlarmState alarmState, AlarmState oldAlarmState) {
    this.alarmId = alarmId;
    this.alarmDefinitionId = alarmDefinitionId;
    this.tenantId = tenantId;
    this.alarmMetrics = alarmMetrics;
    this.subAlarms = subAlarmMetricDefinitions;
    this.alarmState = alarmState;
    this.oldAlarmState = oldAlarmState;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof AlarmUpdatedEvent))
      return false;
    AlarmUpdatedEvent other = (AlarmUpdatedEvent) obj;
    if (alarmDefinitionId == null) {
      if (other.alarmDefinitionId != null)
        return false;
    } else if (!alarmDefinitionId.equals(other.alarmDefinitionId))
      return false;
    if (alarmId == null) {
      if (other.alarmId != null)
        return false;
    } else if (!alarmId.equals(other.alarmId))
      return false;
    if (tenantId == null) {
      if (other.tenantId != null)
        return false;
    } else if (!tenantId.equals(other.tenantId))
      return false;
    if (alarmMetrics == null) {
      if (other.alarmMetrics != null)
        return false;
    } else if (!alarmMetrics.equals(other.alarmMetrics))
      return false;
    if (subAlarms == null) {
      if (other.subAlarms != null)
        return false;
    } else if (!subAlarms.equals(other.subAlarms))
      return false;
    if (alarmState != other.alarmState)
      return false;
    if (oldAlarmState != other.oldAlarmState)
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((alarmDefinitionId == null) ? 0 : alarmDefinitionId.hashCode());
    result = prime * result + ((alarmId == null) ? 0 : alarmId.hashCode());
    result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
    result = prime * result + ((alarmMetrics == null) ? 0 : alarmMetrics.hashCode());
    result =
        prime * result
            + ((subAlarms == null) ? 0 : subAlarms.hashCode());
    result = prime * result + ((alarmState == null) ? 0 : alarmState.hashCode());
    result = prime * result + ((oldAlarmState == null) ? 0 : oldAlarmState.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "AlarmUpdatedEvent [alarmId=" + alarmId + ", alarmDefinitionId=" + alarmDefinitionId
        + ", tenantId=" + tenantId + ", alarmMetrics=" + alarmMetrics + ", alarmState="
        + alarmState + ", oldAlarmState=" + oldAlarmState + ", subAlarms=" + subAlarms + "]";
  }
}
