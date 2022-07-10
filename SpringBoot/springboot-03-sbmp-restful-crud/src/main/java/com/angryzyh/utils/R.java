package com.angryzyh.utils;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class R {
    @NonNull
    private boolean flag;

    private Object data;
}
