/*
 * Copyright (c) 2021 amy, All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holder nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.mewna.catnip.entity.builder.component;

import com.mewna.catnip.entity.impl.message.component.ButtonImpl;
import com.mewna.catnip.entity.message.component.Button;
import com.mewna.catnip.entity.message.component.Button.ButtonStyle;
import com.mewna.catnip.entity.misc.Emoji;
import lombok.Setter;

/**
 * @author amy
 * @since 5/30/21.
 */
@Setter
public class ButtonBuilder {
    private ButtonStyle style;
    private String label;
    private Emoji emoji;
    private String customId;
    private String url;
    private boolean disabled;
    
    public Button build() {
        if(style == null) {
            throw new IllegalStateException("Buttons must have a style");
        }
        if(url != null && customId != null) {
            throw new IllegalStateException("Buttons must have a url or a custom id, not both");
        }
        if(label != null && label.length() > 80) {
            throw new IllegalStateException("Button labels must be at most 80 characters");
        }
        if(customId != null && customId.length() > 100) {
            throw new IllegalStateException("Button custom ids must be at most 100 characters");
        }
        return new ButtonImpl(style, label, emoji, customId, url, disabled);
    }
}
