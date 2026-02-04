package com.example.common.db

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "sample_items")
open class SampleItem(
    @Column(name = "name", nullable = false, length = 200)
    var name: String = "",
) : BaseEntity()
