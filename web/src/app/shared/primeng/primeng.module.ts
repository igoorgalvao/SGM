import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ButtonModule } from 'primeng-lts/button';


const PRIMENG_COMPONENTS = [
    ButtonModule
];

@NgModule({
    declarations: [],
    imports: [
        CommonModule,

        PRIMENG_COMPONENTS
    ],
    exports: [
        PRIMENG_COMPONENTS
    ]
})
export class PrimengModule {
}
