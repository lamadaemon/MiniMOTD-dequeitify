![MiniMOTD logo](https://i.imgur.com/CXWwjOJ.png)

[![build](https://img.shields.io/github/checks-status/jpenilla/MiniMOTD/master?label=build)](https://github.com/jpenilla/MiniMOTD/actions) [![latest release](https://img.shields.io/github/v/release/jpenilla/MiniMOTD)](https://github.com/jpenilla/MiniMOTD/releases)

### About this fork

Nice mod but the author is 100% brain dead so I fixed it.
  - Since I only need fabric version, so I dropped everything else
  - Removed weired build-logic (What's wrong with buildSrc)
  - Dequeitify
    - Change quiet to original fabric
    - 1.21 Support

Under the premise of not conflicting with the original project’s open source license (MIT), 
all modifications to the original work and new code, resources, etc., are open sourced under the Anti-996 license.
For all conflicting terms, the open source license (MIT) of the original work should be prioritized.
The author of this fork (lamadaemon) reserves the right to final interpretation.

### MiniMOTD is a basic server list MOTD plugin/mod for Minecraft servers and proxies

- MiniMOTD supports RGB colors and gradients through [MiniMessage](https://github.com/KyoriPowered/adventure-text-minimessage), which is also where MiniMOTD gets it's name.
- For more detailed info on formatting text, refer to the [MiniMessage docs](https://docs.adventure.kyori.net/minimessage.html).
- RGB colors are automatically downsampled for outdated clients.
- RGB colors are only able to be sent by proxies and 1.16+ servers, and can only be seen by 1.16+ clients.
