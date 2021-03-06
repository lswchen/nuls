package io.nuls.network.message;

import io.nuls.core.chain.entity.BaseNulsData;
import io.nuls.core.utils.io.NulsByteBuffer;
import io.nuls.network.constant.NetworkConstant;
import io.nuls.network.message.entity.GetVersionData;
import io.nuls.network.message.entity.VersionData;
import io.nuls.network.module.AbstractNetworkModule;

/**
 * @author vivi
 * @date 2017/11/21
 */
public abstract class BaseNetworkData extends BaseNulsData {

    protected NetworkDataHeader networkHeader;

    public BaseNetworkData(NulsByteBuffer buffer) {
        super(buffer);
    }

    public BaseNetworkData(short mainVersion, short subVersion, short type) {
        super(mainVersion, subVersion);
        this.networkHeader = new NetworkDataHeader(AbstractNetworkModule.networkModuleId, type);
    }

    public BaseNetworkData(short mainVersion, short subVersion, NetworkDataHeader networkHeader) {
        super(mainVersion, subVersion);
        this.networkHeader = networkHeader;
    }

    public static BaseNetworkData transfer(Short type, byte[] data) {
        BaseNetworkData networkData = null;
        switch (type) {
            case NetworkConstant.NETWORK_GET_VERSION_MESSAGE:
                networkData = new GetVersionData();
                break;
            case NetworkConstant.NETWORK_VERSION_MESSAGE:
                networkData = new VersionData();
                break;

            default:
        }
        networkData.parse(new NulsByteBuffer(data));
        return networkData;
    }

    public NetworkDataHeader getNetworkHeader() {
        return networkHeader;
    }

    public void setNetworkHeader(NetworkDataHeader networkHeader) {
        this.networkHeader = networkHeader;
    }
}
