package dev.zwander.common.model.adapters

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainData(
    val device: DeviceData,
    val signal: SignalData,
    val time: TimeData,
)

@Serializable
data class DeviceData(
    val friendlyName: String,
    val hardwareVersion: String,
    val isEnabled: Boolean,
    val isMeshSupported: Boolean,
    val macId: String,
    val manufacturer: String,
    val model: String,
    val name: String,
    val role: String,
    val serial: String,
    val softwareVersion: String,
    val type: String,
    val updateState: String,
)

@Serializable
data class SignalData(
    @SerialName("4g")
    val fourG: CellData? = null,
    @SerialName("5g")
    val fiveG: CellData? = null,
    val generic: GenericData? = null,
)

@Serializable
data class CellData(
    val bands: List<String>,
    val bars: Double,
    val cid: Long,
    val eNBID: Long,
    val rsrp: Int,
    val rsrq: Int,
    val rssi: Int,
    val sinr: Int,
)

@Serializable
data class GenericData(
    val apn: String,
    val hasIPv6: Boolean,
    val registration: String,
    val roaming: Boolean,
)

@Serializable
data class TimeData(
    val daylightSavings: DaylightSavingsData?,
    val localTime: Long?,
    val localTimeZone: String?,
    val upTime: Long?,
)

@Serializable
data class DaylightSavingsData(
    val isUsed: Boolean,
)
