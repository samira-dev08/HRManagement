package com.company.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


public enum LeaveType {
    CASUAL,
    MEDICAL,
    PERSONAL,
    MATERNITY
}
