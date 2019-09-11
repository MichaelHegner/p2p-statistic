package net.hemisoft.p2p.converter.plattform.peerberry.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.peerberry.dto.PeerberryAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountCsvLineMapper

@Component
class PeerberryAccountCsvLineMapper extends AbstractAccountCsvLineMapper<PeerberryAccountDto> {
	@Override PeerberryAccountDto createNewDto() { PeerberryAccountDto.newInstance() }
}